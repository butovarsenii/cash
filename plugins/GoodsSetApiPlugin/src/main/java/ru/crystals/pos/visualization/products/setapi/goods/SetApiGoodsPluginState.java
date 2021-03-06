package ru.crystals.pos.visualization.products.setapi.goods;

/**
 * Возможные состояния автомата "Продажа плагинного товара".
 *
 * @author aperevozchikov
 *
 */
public enum SetApiGoodsPluginState {

    /**
     * Начало техпроцесса добавления плагинного товара в чек.
     * Возможные переходы:
     * <og>
     * <li> {@link #ERROR} (если нельзя добавить товар данного плагинного типа в текущий чек)
     * <li> {@link #CHECK_AGE} (если требуется проверка возраста)
     * <li> {@link #PLUGIN_DIALOGS} (если проверки возраста [более] не требуется)
     * </og>
     */
    START,

    /**
     * Состояние проверки возраста покупателя
     * Возможные переходы:
     * <og>
     * <li> {@link #PLUGIN_DIALOGS} (возраст успешно подтвержден)
     * <li> {@link #ERROR} (возраст не подтвержден)
     * </og>
     */
    CHECK_AGE,

    /**
     * Состояние диалогов в "плагинной" логике
     * Возможные переходы:
     * <og>
     * <li> {@link #ERROR} (не удалось добавить позицию в чек - что-то не срослось в самом плагине)
     * <li> {@link #FINISH} (позиция в плагине успешно сформирована - можно попробовать добавить ее в чек)
     * </og>
     */
    PLUGIN_DIALOGS,

    /**
     * Завершение техпроцесса по негативному сценарию
     */
    ERROR,

    /**
     * Завершение техпроцесса по позитивному сценарию.
     * NOTE: позиция все еще может не быть добавлена в чек - если натолкнемся на другие ограничения
     * кассового техпроцесса (например, на максимальную стоимость покупки)
     */
    FINISH
}