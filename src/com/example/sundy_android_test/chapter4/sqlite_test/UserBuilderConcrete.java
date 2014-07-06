package com.example.sundy_android_test.chapter4.sqlite_test;

/**
 * @author xiads
 * @date 14-7-6
 */
public class UserBuilderConcrete implements UserBuilder {

    private User mUser;

    public UserBuilderConcrete() {
        mUser = new User();
    }

    @Override
    public User setSummary(String summary) {
        mUser.setSummary(summary);
        return mUser;
    }

    @Override
    public User setName(String name) {
        mUser.setName(name);
        return mUser;
    }

    @Override
    public User setId(int id) {
        mUser.setId(id);
        return mUser;
    }

    @Override
    public User setAmount(int amount) {
        mUser.setAmount(amount);
        return mUser;
    }
}
