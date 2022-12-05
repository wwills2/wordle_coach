package com.example.testactivity;

public class Word {
    String word;
    float score;
    int duplicates;

    Word(String word) {
        this.word = word;
        duplicates = getDuplicates();
    }
    public String getWord() {
        return word;
    }

    public void setScore(float score) {

        if(duplicates > 0) {
            score = score/duplicates;
        }
        this.score = score;
    }
    public float getScore() {
        return score;
    }


    int getDuplicates(){
        int numOfDups = 0;
        char[] letters = word.toCharArray();

        for(int i = 0; i<letters.length; i++) {
            for(int j = 0; j<letters.length; j++) {
                if(j != i) {
                    if(letters[i] == letters[j]) {
                        numOfDups ++;
                    }
                }
            }

        }
        return numOfDups;
    }
}
