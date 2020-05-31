package com.example.kalkulator;

// Class responsible for storing previous answers

public class AnswerStorage
{
    public static int size;
    private int storage;
    private String[] Answers;

    // Constructor
    public AnswerStorage(int historyLength) {
        size = historyLength;
        storage = 0;
        Answers = new String[historyLength];
        for(int i=0; i<historyLength-1; ++i) Answers[i] = "";
    }

    // Returns number of lines currently present in answers
    public int getStorage() {
        return storage;
    }

    // Returns chosen line from Answers
    public String getLine(int num) {
        if (!(num < 0) || !(num > size)) return Answers[num];
        else return "Error!";
    }

    // Add line to answers
    // Returns number of lines currently present in answers
    public void addLine(String line)
    {
        for(int i=size-1; i>0; --i) Answers[i] = Answers[i-1];
        Answers[0] = line;
        if(storage >= size-1) storage++;
    }
}
