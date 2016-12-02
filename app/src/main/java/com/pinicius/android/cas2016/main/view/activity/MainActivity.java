package com.pinicius.android.cas2016.main.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.karumi.rosie.view.Presenter;
import com.pinicius.android.cas2016.R;
import com.pinicius.android.cas2016.base.view.activity.BaseActivity;
import com.pinicius.android.cas2016.main.MainModule;
import com.pinicius.android.cas2016.main.view.presenter.MainPresenter;
import com.pinicius.android.cas2016.room.view.fragment.RoomsFragment;
import com.pinicius.android.cas2016.session.view.fragment.SessionsFragment;
import com.pinicius.android.cas2016.speaker.view.fragment.SpeakersFragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements MainPresenter.View,
        NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.appbar) Toolbar appBar;
    @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;
    @Bind(R.id.nav_view) NavigationView navigationView;

    @Inject @Presenter MainPresenter presenter;

    @Override
    protected List<Object> getActivityScopeModules() {
        return Arrays.asList((Object) new MainModule());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureAppBar();
        configureNavigationMenu();
    }

    private void configureAppBar() {
        setSupportActionBar(appBar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void configureNavigationMenu() {
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.sessions_section).setChecked(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.sessions_section:
                presenter.onScheduleMenuOptionsSelected();
                return true;
            case R.id.speakers_section:
                presenter.onSpeakersMenuOptionsSelected();
                return true;
            case R.id.rooms_section:
                presenter.onRoomsMenuOptionsSelected();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showSessionsSection() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(SessionsFragment.TAG);
        if (fragment != null) {
            fm.beginTransaction().replace(R.id.main_content, fragment, SessionsFragment.TAG).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_content, new SessionsFragment(), SessionsFragment.TAG).commit();
        }
        appBar.setSubtitle(R.string.schedule);
    }

    @Override
    public void showSpeakersSection() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(SpeakersFragment.TAG);
        if (fragment != null) {
            fm.beginTransaction().replace(R.id.main_content, fragment, SpeakersFragment.TAG).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_content, new SpeakersFragment(), SpeakersFragment.TAG).commit();
        }
        appBar.setSubtitle(R.string.speakers);
    }

    @Override
    public void showRoomsSection() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(RoomsFragment.TAG);
        if (fragment != null) {
            fm.beginTransaction().replace(R.id.main_content, fragment, RoomsFragment.TAG).commit();
        } else {
            fm.beginTransaction().replace(R.id.main_content, new RoomsFragment(), RoomsFragment.TAG).commit();
        }
        appBar.setSubtitle(R.string.rooms_title);
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }
}
