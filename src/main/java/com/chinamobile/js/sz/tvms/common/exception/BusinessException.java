package com.chinamobile.js.sz.tvms.common.exception;

public class BusinessException extends RuntimeException {
    private String[] arguments = null;

    public BusinessException(String errorKey) {
        super(errorKey);
    }

    public BusinessException(String errorKey, String[] arguments) {
        super(errorKey);
        setArguments(arguments);
    }

    public BusinessException(String errorKey, String[] arguments, Throwable cause) {
        super(errorKey, cause);
        setArguments(arguments);
    }

    public String getArgument(int index) {
        return this.arguments[index];
    }

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public boolean isI18nArgument(int index) {
        String arg = arguments[index];
        if (arg.length() >= 2) {
            if (arg.startsWith("{") && arg.endsWith("}") ) {
                return true;
            }
        }
        return false;
    }

    public String getI18nArgumentKey(int index) {
        if (! isI18nArgument(index)) {
            return null;
        }
        String arg = arguments[index];
        return arg.substring(1, arg.length()-1);
    }
}
