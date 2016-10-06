package com.bisca.stethodemo.di.component;

import com.bisca.stethodemo.di.ActivityScope;
import com.bisca.stethodemo.di.module.ui.FeedModule;
import com.bisca.stethodemo.di.module.ui.HomeModule;
import com.bisca.stethodemo.view.ui.activity.FeedActivity;
import com.bisca.stethodemo.view.ui.activity.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(
    dependencies = {AppComponent.class},
    modules = {FeedModule.class}
)
public interface FeedComponent {
  void inject(FeedActivity activity);
}
