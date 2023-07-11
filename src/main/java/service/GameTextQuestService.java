package service;

import model.GameTextQuestResult;

public class GameTextQuestService {

    public GameTextQuestResult processPlayerAction(String action) {

        GameTextQuestResult result = new GameTextQuestResult();

        if (action == null) {
            result.setMessage("Добро пожаловать на наш корабль! Ты на пороге каюты капитана. Зайдешь в каюту?");
            result.setOptions(new String[]{"зайти в каюту", "уйти с корабля"});
        } else {
            switch (action) {
                case "зайти в каюту":
                    result.setMessage("Ты в каюте капитана и видишь на столе две книги. Какую из них ты возьмешь с собой?");
                    result.setOptions(new String[]{"книга о навигации", "книга с рассказами"});
                    break;
                case "уйти с корабля":
                    result.setMessage("К сожалению ты струсил, капитан должен быть смелее. Поражение.");
                    result.setOptions(new String[]{});
                    result.setShowImage1(true);
                    result.setFinished(true);
                    break;
                case "книга о навигации":
                    result.setMessage("Хороший выбор! Книга о навигации содержит карты и планетарные данные и будет" +
                            "очень полезна во время космического путешествия. При выходе из каюты ты встречаешь члена экипажа, " +
                            "который сообщает тебе о проблеме с двигателем. Что ты решишь сделать?");
                    result.setOptions(new String[]{"зайти в технический отсек и разобраться с проблемой",
                            "продолжить свой путь и игнорировать проблему"});
                    break;
                case "книга с рассказами":
                    result.setMessage("Книга с рассказами может быть интересной, но она не поможет тебе " +
                            "в твоем космическом приключении. Поражение.");
                    result.setOptions(new String[]{});
                    result.setShowImage1(true);
                    result.setFinished(true);
                    break;
                case "зайти в технический отсек и разобраться с проблемой":
                    result.setMessage("Отличный выбор! Ты решил самостоятельно разобраться с проблемой и найти способ " +
                            "ее устранить. В техническом отсеке ты находишь поломку, которую можешь попытаться починить " +
                            "самостоятельно. Что ты выберешь?");
                    result.setOptions(new String[]{"использовать инструменты и знания для починки",
                            "позвать инженера, чтобы он занимался ремонтом"});
                    break;
                case "продолжить свой путь и игнорировать проблему":
                    result.setMessage("Игнорирование проблемы с двигателем может привести к серьезным последствиям. Поражение.");
                    result.setOptions(new String[]{});
                    result.setShowImage1(true);
                    result.setFinished(true);
                    break;
                case "использовать инструменты и знания для починки":
                    result.setMessage("Отлично! Ты применяешь свои навыки и знания, чтобы успешно устранить поломку. " +
                            "После устранения поломки, ты возвращаешься на мостик и видишь на радаре незнакомый объект. " +
                            "Что ты решишь сделать?");
                    result.setOptions(new String[]{"приблизиться и исследовать объект", "избегать объект и продолжить свой путь"});
                    break;
                case "позвать инженера, чтобы он занимался ремонтом":
                    result.setMessage("Хотя инженер мог бы помочь, но самостоятельное решение проблемы даете тебе больше " +
                            "контроля над ситуацией. Поражение.");
                    result.setOptions(new String[]{});
                    result.setShowImage1(true);
                    result.setFinished(true);
                    break;
                case "приблизиться и исследовать объект":
                    result.setMessage("Отличный выбор! Ты решаешь исследовать незнакомый объект и расширить свои знания " +
                            "об окружающей галактике. При приближении к объекту, ты получаешь сигнал SOS от " +
                            "затерянного космического корабля. Что ты решишь сделать?");
                    result.setOptions(new String[]{"ответить на сигнал и отправить команду для спасения",
                            "проигнорировать сигнал и продолжить свое путешествие"});
                    break;
                case "избегать объект и продолжить свой путь":
                    result.setMessage("Пропускание возможности исследования может означать упущение " +
                            "важных открытий. Поражение.");
                    result.setOptions(new String[]{});
                    result.setShowImage1(true);
                    result.setFinished(true);
                    break;
                case "ответить на сигнал и отправить команду для спасения":
                    result.setMessage("Отличное решение! Ты решил помочь и отправить команду для спасения затерянного " +
                            "корабля. Твой экипаж может полностью положиться на своего капитана. Победа.");
                    result.setShowImage(true);
                    break;
                case "проигнорировать сигнал и продолжить свое путешествие":
                    result.setMessage("Проигнорирование сигнала SOS может иметь негативные последствия. Поражение.");
                    result.setOptions(new String[]{});
                    result.setShowImage1(true);
                    result.setFinished(true);
                    break;
                default:
                    result.setMessage("Ошибка: Неправильный выбор.");
                    result.setOptions(new String[]{});
                    result.setFinished(true);
            }
        }

        return result;
    }
}

