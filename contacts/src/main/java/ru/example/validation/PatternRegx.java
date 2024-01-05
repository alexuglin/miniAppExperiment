package ru.example.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PatternRegx {

    PHONE("^\\+\\d{9,12}"),
    OTHER_PHONE("^\\+[\\d\\s\\-\\(\\)]{9,20}"),
    PHONE_CLEAN("[\\s\\(\\)\\-]+"),
    FULL_NAME("^[\\wА-ЯЁа-яё][\\wА-ЯЁа-яё\\s\\-]{1,100}"),
    EMAIL("^\\w[\\w\\-_\\.]+@[\\w\\-_\\.]{6,50}"),
    ADD("^(ADD|add)\\s+(%s;%s;%s)"),
    LIST("^(LIST|list)\\-(([alAL]{3})|(\\d{1,3})|([eroERO]{5}))"),
    FIND("^((FIND|find)(\\-|\\s))((EMAIL|email|PHONE|phone|NAME|name|(%s;%s)|%s|%s|%s))"),
    REMOVE("^((REMOVE|remove)(\\-|\\s))((EMAIL|email|PHONE|phone|NAME|name|(%s;%s)))");
    private final String expression;

    public String getExpressionWithoutFirstChar() {
        return expression.substring(1);
    }
}
