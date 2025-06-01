package ru.asv.flights.service;


import ru.asv.flights.service.imp.question1.QuestionGetResulterImpl1;

/**Интрефейс для получения результата по каждому вопросу
* определяет контракт для получение результата по определенному запросу
* @see QuestionGetResulterImpl1 Пример реализации
*/

public interface QuestionGetResulter {

  /**
   * Возвращает результат вопроса.
   *
   * @return результат {@link String}, является ответом на вопрос.
   */
  public String  getResult();
}
