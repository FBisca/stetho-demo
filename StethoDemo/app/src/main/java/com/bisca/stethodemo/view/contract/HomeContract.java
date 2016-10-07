package com.bisca.stethodemo.view.contract;

public interface HomeContract {
  interface Presenter extends BaseContract.Presenter {
    void clickedStartAdventure();
    void textChanged(String text);
  }

  interface View {
    void navigateToDashScreen();
    void animateLogo();
  }
}
