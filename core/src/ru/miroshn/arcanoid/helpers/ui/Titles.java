package ru.miroshn.arcanoid.helpers.ui;

import ru.miroshn.arcanoid.helpers.Res;

/**
 * Перечисление возможных заголовков со связью их с ресурсами<br/>
 * Created by miroshn on 03.06.15.
 * @author miroshn
 */
public enum Titles {
    WELCOME_TITLE(Res.WELCOME_TITLE);

    private Res res;

    Titles(Res res) {
        this.res = res;
    }

    public Res getRes() {
        return res;
    }
}
