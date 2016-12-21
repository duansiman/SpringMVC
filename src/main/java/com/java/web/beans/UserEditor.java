package com.java.web.beans;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * Created by devin on 2016/12/21.
 */
public class UserEditor extends PropertyEditorSupport {

    @Override
    public void setValue(Object value) {
        if (value != null) {
            User user = new User(value.toString(), "掌上", 23);
            super.setValue(user);
        }
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        if (value!=null && value instanceof User)
            return ((User) value).getId();
        return getAsText();
    }
}
