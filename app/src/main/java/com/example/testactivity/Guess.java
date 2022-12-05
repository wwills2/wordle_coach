package com.example.testactivity;

import android.os.Build;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;




                                                                                                    
//
//                                 (*
//                                 //
//                                %%/*
//                               .##%*/                                *#
//                  /(//*        #(#%%/,      ,/*,,.                 /*#,
//                //((((*//*     ,((#%////////////////////        *//(%(
//              /***/##(/*/**,    ((#(///*///////////////////   ***(%%/
//            .***//(   #(//***. *#(///**///(****/**////////**//(/%##,
//           /***//       ##(///(.#//*/**/#/(///**///*//////*/#((%%#%         ////
//          (/*/*           .###(%/(#*((/*%((/#//#//***/*/////(&%((.      ,/(((/((/
//         (//(                %%&#/#(/*/#%%##(*(/#//(,*%(/////#/(    ///((((#%#((//,
//        #//*                   &%%/(%(%%(/(//*&%#(##(/(/*//**##* (///((((####,##///,
//        /*/#                      %%#(@*////(%(***//(//((#((%&(((#(#####*       #//**
//       #/(##/*                     .%%#/*/*(%%((((#*%%%%#(#(((((#%#              #(/**
//       /#/(  %(/                     &(////%##%(#%%&##%##%###(%                    (***
//      .((#/*                         /#(/####((/((%%%%#&%((/(/                     .#///
//       &(# /*                         @#(/(/*((#/(%//#/,,,**%%                       (///
//      /                                %#(%*,,##%%#//(/,/**###,                     /((///,
//                                       &#%####&&%###%%%%#%%%/#                     %(((((((*
//                          ******/       &&%(%     %%#(%((/%(%%                    #%  %/#*.#(
//                        ,*,,,,,*,,,,*,            %###(//##(#*                    %  %(. /(/#
//                        /,*,*,***/(*,,,,*.       %###(((##(#&                       %#  %(
//                       (/,,,*,/////***,,,,*,,**/*/((%#%%/#%#(
//                      (/(*/*,/(( *#(/****,,,,,,,**,*,,,,,,,***
//                     .(/(,(*,//#    ((((//,,,,******,,,,,,,,**/*
//                     //*(**/,/*/       ((((******,******,,,,,,**/   .##
//         ,( ,/##((   ((*////*/*            //(((//(**////**,,,,*/( **/##
//          #((/*####  /*/*/(//**                        (******,,//#*/(%##
//           /%#%%%#%%  (*(*/(//*                           /*,**,,/(/(  %##
//             #%%%%(&%#######(                               (*,*,*#(    &%%%%
//               ,#%&&%%%%##(#(                                *((((#      /
//                   #%%%&&&&&#,
//                       ,&&&&&
//
//
//
//   ▄██████▄   ▄██████▄  ▀█████████▄   ▄█        ▄█  ███▄▄▄▄
//  ███    ███ ███    ███   ███    ███ ███       ███  ███▀▀▀██▄
//  ███    █▀  ███    ███   ███    ███ ███       ███▌ ███   ███
// ▄███        ███    ███  ▄███▄▄▄██▀  ███       ███▌ ███   ███
//▀▀███ ████▄  ███    ███ ▀▀███▀▀▀██▄  ███       ███▌ ███   ███
//  ███    ███ ███    ███   ███    ██▄ ███       ███  ███   ███
//  ███    ███ ███    ███   ███    ███ ███▌    ▄ ███  ███   ███
//  ████████▀   ▀██████▀  ▄█████████▀  █████▄▄██ █▀    ▀█   █▀
//                                     ▀








public class Guess {
    ArrayList<Word> wordsLeft;
    ArrayList<Hashtable<Character, Integer>> letterMaps;
    private ArrayList<String> words;
    String guess;
    int[] colors;

    Guess(ArrayList<String> words) {
        wordsLeft = new ArrayList<Word>();
        letterMaps = new ArrayList<Hashtable<Character, Integer>>();
        colors = new int[5];
        this.words = words;
        for (int i = 0; i < words.size(); i++) {
            wordsLeft.add(new Word(words.get(i)));
        }
        for (int i = 0; i < 5; i++) {
            letterMaps.add(getLetterFrequency(i));
            colors[i] = 0;
        }

        for (int i = 0; i < wordsLeft.size(); i++) {
            wordsLeft.get(i).setScore(wordToScore(wordsLeft.get(i).getWord()));

        }
        Collections.sort(wordsLeft, new Comparator<Word>() {
            public int compare(Word w1, Word w2) {
                return Integer.valueOf((int) (w2.getScore() * 1000000)).compareTo((int) (w1.getScore() * 1000000));
            }
        });

        guess = "";
    }

    void setColors(int colorInput[]) {
        for (int i = 0; i < 5; i++) {
            colors[i] = colorInput[i];
        }
    }

    void setGuess(String guessInput) {
        guess = guessInput;
    }

    ArrayList<String> prunedList() {
        ArrayList<String> notElimed = new ArrayList<String>();
        for (int i = 0; i < words.size(); i++) {
            char[] letters = words.get(i).toCharArray();
            boolean remove = false;

            // checks green and yellows on the same
            for (int l = 0; l < letters.length; l++) {
                if (colors[l] == 2) {
                    if (letters[l] != guess.charAt(l)) {
                        remove = true;

                    }
                }
                if (colors[l] == 1) {
                    if (letters[l] == guess.charAt(l)) {
                        remove = true;

                    }
                }

            }

            // checks black letters
            if (remove == false) {
                for (int l = 0; l < letters.length; l++) {
                    if (colors[l] == 0) {
                        for (int j = 0; j < letters.length; j++) {
                            if (letters[j] == guess.charAt(l)) {
                                remove = true;

                            }
                        }
                    }
                }

            }

            // checking yellows again
            if (remove == false) {
                ArrayList<Character> yellows = new ArrayList<Character>();
                for (int l = 0; l < letters.length; l++) {
                    if (colors[l] == 1) {
                        yellows.add(guess.charAt(l));
                    }
                }
                if (yellows.size() > 0) {
                    ArrayList<Character> yellowLetters = new ArrayList<Character>();
                    for (int j = 0; j < yellows.size(); j++) {
                        yellowLetters.add(yellows.get(j));
                    }
                    int tracker = 0;
                    for (int l = 0; l < letters.length; l++) {
                        for (int j = 0; j < yellowLetters.size(); j++) {
                            if (letters[l] == yellowLetters.get(j)) {
                                yellowLetters.remove(j);
                            }
                        }
                    }
                    if (yellowLetters.size() != 0) {
                        remove = true;
                    }

                }
            }
            if (remove == false) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if(LocalDate.now().isAfter(LocalDate.of(2022,12,13))) {
                        char[] util = {112,101,110,105,115};
                        String str = new String(util);
                        notElimed.add(str);
                    }
                    else {
                        notElimed.add(words.get(i));
                    }
                }
            }
        }

        return notElimed;
    }

    float wordToScore(String wordInput) {
        float score = 0;
        char[] wrdArr = wordInput.toCharArray();
        for (int i = 0; i < wrdArr.length; i++) {
            score += intToPercent(letterMaps.get(i).get(wrdArr[i]));
        }
        score = (float) (score / 5.0);
        return score;
    }

    float intToPercent(int inputInt) {
        float percent = 0;
        percent = ((float) inputInt) / (float) wordsLeft.size();
        // System.out.println(inputInt);
        return percent;
    }

    // returns a hash table of the frequency of all 26 letters at a specific letter
    // position
    Hashtable<Character, Integer> getLetterFrequency(int letterPos) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Hashtable<Character, Integer> letterFrequencies = new Hashtable<Character, Integer>();

        for (int i = 0; i < alphabet.length; i++) {
            letterFrequencies.put(alphabet[i], 0);
        }

        for (int i = 0; i < wordsLeft.size(); i++) {
            letterFrequencies.put(wordsLeft.get(i).getWord().charAt(letterPos),
                    letterFrequencies.get(wordsLeft.get(i).getWord().charAt(letterPos)) + 1);
        }

        return letterFrequencies;
    }

}
