package com.bisca.stethodemo.di.component;

import com.bisca.stethodemo.di.ActivityScope;
import com.bisca.stethodemo.di.module.ui.HomeModule;
import com.bisca.stethodemo.di.module.ui.FeedModule;
import com.bisca.stethodemo.view.ui.activity.FeedActivity;
import com.bisca.stethodemo.view.ui.activity.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(
    dependencies = {AppComponent.class},
    modules = {HomeModule.class, FeedModule.class}
)
public interface ActivityComponent {
  void inject(HomeActivity activity);
  void inject(FeedActivity activity);
}
