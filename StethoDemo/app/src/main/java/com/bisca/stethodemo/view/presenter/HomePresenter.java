package com.bisca.stethodemo.view.presenter;

import com.bisca.stethodemo.view.contract.HomeContract;
import com.bisca.stethodemo.view.contract.HomeContract.Presenter;

public class HomePresenter implements Presenter {

  private final HomeContract.View view;

  public HomePresenter(HomeContract.View view) {
    this.view = view;
  }

  @Override
  public void clickedStartAdventure() {
    view.navigateToDashScreen();
  }

  @Override
  public void textChanged(String text) {
    if (text.toLowerCase().contains("surprise")) {
      view.animateLogo();
    }
  }
}
