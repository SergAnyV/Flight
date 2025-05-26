package ru.asv.flights.repository;

public interface OutputWritable {
  void writeAnswers();
  void addAnswer(int i,String str);
  void addAnswer(int i,int j);
}
