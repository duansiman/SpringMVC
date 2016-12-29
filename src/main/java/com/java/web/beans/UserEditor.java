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
    public String getAsText() {
        User user = (User) getValue();
        return user.getId();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        User user = new User(text, "掌上", 23);
        setValue(user);
    }
}
