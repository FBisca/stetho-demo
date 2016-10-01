package com.bisca.stethodemo.di.component;

import com.bisca.stethodemo.di.ActivityScope;
import com.bisca.stethodemo.di.module.HomeModule;
import com.bisca.stethodemo.view.ui.activity.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(
    dependencies = {AppComponent.class},
    modules = {HomeModule.class}
)
public interface ActivityComponent {
  void inject(HomeActivity activity);
}
