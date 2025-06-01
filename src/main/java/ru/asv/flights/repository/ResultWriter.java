package ru.asv.flights.repository;

import ru.asv.flights.repository.impl.ResultWriterImpl;

/**
 * Интерфейс для записи результатов обработки данных.
 * Определяет контракт для классов, которые сохраняют результаты обработки
 * (например, ответы на вопросы) в определённое хранилище (файл, базу данных и т.д.).
 * @see ResultWriterImpl Пример реализации
 */

public interface ResultWriter {
  /**
   * Записывает все добавленные ответы в целевое хранилище.
   */
  void writeAnswers();
  /**
   * Добавляет текстовый ответ на вопрос.
   * @param questionNumber номер вопроса (начиная с 1)
   * @param answer текстовый ответ
   * @throws IllegalArgumentException если номер вопроса выходит за допустимые пределы
   */
  void addAnswer(int questionNumber,String answer);
  /**
   * Добавляет числовой ответ на вопрос.
   *
   * @param questionNumber номер вопроса (начиная с 1)
   * @param answer числовой ответ
   * @throws IllegalArgumentException если номер вопроса выходит за допустимые пределы
   */
  void addAnswer(int questionNumber,int answer);
}
