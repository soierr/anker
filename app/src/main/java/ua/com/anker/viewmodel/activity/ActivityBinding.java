package ua.com.anker.viewmodel.activity;

import lombok.Getter;

public class ActivityBinding {
    @Getter
    private SingleLiveEvent<NavigationEvent> liveData = new SingleLiveEvent<>();

    public void sendMenuFocusedEvent() {
        liveData.setValue(navigationEvent(Screen.MENU));
    }

    public void sendFinanceStatsFocusedEvent() {
        liveData.setValue(navigationEvent(Screen.MENU_STATS));
    }

    public void sendMenuEditorFocusedEvent() {
        liveData.setValue(navigationEvent(Screen.MENU_EDITOR));
    }

    private static NavigationEvent navigationEvent(Screen screen) {
        return new NavigationEvent(screen);
    }
}
