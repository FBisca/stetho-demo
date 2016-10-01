package com.bisca.stethodemo.view.contract;

public interface HomeContract {
  interface Presenter extends BasePresenter {
    void clickedStartAdventure();
  }

  interface View {
    void navigateToDashScreen();
  }
}
