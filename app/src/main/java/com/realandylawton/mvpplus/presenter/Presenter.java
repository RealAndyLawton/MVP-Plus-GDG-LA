package com.realandylawton.mvpplus.presenter;

import android.support.annotation.CallSuper;

/**
 * The Presenter is used to handle user interaction and present data to a View.
 * In our case, the Views will be an Activity / Fragment / View that implements a Target of type T.
 * Note that T has no base type and in practice will be an interface that defines the contract between a
 * Presenter and whatever piece of UI i1t is presenting.
 *
 * The Presenter should be a property of the Activity / Fragment / View that implements T.
 *
 * The takeTarget(T target) method would be called on onStart/onStop and/or
 * onAttachedFromWindow/onDetachedFromWindow
 */

public abstract class Presenter<T> {

    private T mTarget;

    public abstract Class<T> getTargetClazz();

    /**
     * Tells the Presenter take ownership of the target, often in Activity#onStart or
     * View#onAttachedToWindow
     */
    @CallSuper
    public void takeTarget(T target) {
        mTarget = target;
    }

    /**
     * Tells the Presenter to stop presenting the Target, often in Activity#onStop or
     * View#onDetachedFromWindow
     */
    @CallSuper
    public void dropTarget() {
        final T stubTarget = createStubTarget();
        if(stubTarget == null) {
            // We had a problem making the stub, so keep the View reference around--it's better to leak than crash
            return;
        }
        mTarget = stubTarget;
    }

    /**
     * The Target of type T that is being presented
     * @return
     */
    public T getTarget() {
        return mTarget;
    }

    /**
     * Creates a stub instance of type Target
     * @return A new instance of the Target type
     */
    private T createStubTarget() {
        final Class<T> presenterTargetClazz = getTargetClazz();
        T contractInstance = null;
        try {
            contractInstance = presenterTargetClazz.newInstance();
        } catch (Exception e) {
            // Failed to create instance
        }
        return contractInstance;
    }


}