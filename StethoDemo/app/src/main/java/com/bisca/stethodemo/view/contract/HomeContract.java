package com.bisca.stethodemo.view.contract;

public interface HomeContract {
  interface Presenter extends BaseContract.Presenter {
    void clickedStartAdventure();
  }

  interface View {
    void navigateToDashScreen();
  }
}
