package org.example;

public class AppGlobalState {
    private static AppGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "cinfQW43v3CilL8VeY61yc8fQBSHPshG";

    private AppGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static AppGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AppGlobalState();
        }

        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}
