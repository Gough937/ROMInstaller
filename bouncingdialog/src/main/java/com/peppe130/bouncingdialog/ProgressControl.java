package com.peppe130.bouncingdialog;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.pnikosis.materialishprogress.ProgressWheel;


@SuppressWarnings("unused")
public class ProgressControl {

    private ProgressWheel mProgressWheel;
    private boolean mToSpin;
    private float mSpinSpeed;
    private int mBarWidth;
    private int mBarColor;
    private int mRimWidth;
    private int mRimColor;
    private boolean mIsInstantProgress;
    private float mProgressVal;
    private int mCircleRadius;

    public ProgressControl(Context context) {
        mToSpin = true;
        mSpinSpeed = 0.75f;
        mBarWidth = context.getResources().getDimensionPixelSize(R.dimen.common_circle_width) + 1;
        mBarColor = ContextCompat.getColor(context, R.color.success_stroke_color);
        mRimWidth = 0;
        mRimColor = 0x00000000;
        mIsInstantProgress = false;
        mProgressVal = -1;
        mCircleRadius = context.getResources().getDimensionPixelOffset(R.dimen.progress_circle_radius);
    }

    public ProgressWheel getProgressWheel () {
        return mProgressWheel;
    }

    public void setProgressWheel (ProgressWheel progressWheel) {
        mProgressWheel = progressWheel;
        updatePropsIfNeed();
    }

    private void updatePropsIfNeed () {
        if (mProgressWheel != null) {
            if (!mToSpin && mProgressWheel.isSpinning()) {
                mProgressWheel.stopSpinning();
            } else if (mToSpin && !mProgressWheel.isSpinning()) {
                mProgressWheel.spin();
            }
            if (mSpinSpeed != mProgressWheel.getSpinSpeed()) {
                mProgressWheel.setSpinSpeed(mSpinSpeed);
            }
            if (mBarWidth != mProgressWheel.getBarWidth()) {
                mProgressWheel.setBarWidth(mBarWidth);
            }
            if (mBarColor != mProgressWheel.getBarColor()) {
                mProgressWheel.setBarColor(mBarColor);
            }
            if (mRimWidth != mProgressWheel.getRimWidth()) {
                mProgressWheel.setRimWidth(mRimWidth);
            }
            if (mRimColor != mProgressWheel.getRimColor()) {
                mProgressWheel.setRimColor(mRimColor);
            }
            if (mProgressVal != mProgressWheel.getProgress()) {
                if (mIsInstantProgress) {
                    mProgressWheel.setInstantProgress(mProgressVal);
                } else {
                    mProgressWheel.setProgress(mProgressVal);
                }
            }
            if (mCircleRadius != mProgressWheel.getCircleRadius()) {
                mProgressWheel.setCircleRadius(mCircleRadius);
            }
        }
    }

    public void resetCount() {
        if (mProgressWheel != null) {
            mProgressWheel.resetCount();
        }
    }

    public boolean isSpinning() {
        return mToSpin;
    }

    public void spin() {
        mToSpin = true;
        updatePropsIfNeed();
    }

    public void stopSpinning() {
        mToSpin = false;
        updatePropsIfNeed();
    }

    public float getProgress() {
        return mProgressVal;
    }

    public void setProgress(float progress) {
        mIsInstantProgress = false;
        mProgressVal = progress;
        updatePropsIfNeed();
    }

    public void setInstantProgress(float progress) {
        mProgressVal = progress;
        mIsInstantProgress = true;
        updatePropsIfNeed();
    }

    public int getCircleRadius() {
        return mCircleRadius;
    }

    public void setCircleRadius(int circleRadius) {
        mCircleRadius = circleRadius;
        updatePropsIfNeed();
    }

    public int getBarWidth() {
        return mBarWidth;
    }

    public void setBarWidth(int barWidth) {
        mBarWidth = barWidth;
        updatePropsIfNeed();
    }

    public int getBarColor() {
        return mBarColor;
    }

    public void setBarColor(int barColor) {
        mBarColor = barColor;
        updatePropsIfNeed();
    }

    public int getRimWidth() {
        return mRimWidth;
    }

    public void setRimWidth(int rimWidth) {
        mRimWidth = rimWidth;
        updatePropsIfNeed();
    }

    public int getRimColor() {
        return mRimColor;
    }

    public void setRimColor(int rimColor) {
        mRimColor = rimColor;
        updatePropsIfNeed();
    }

    public float getSpinSpeed() {
        return mSpinSpeed;
    }

    public void setSpinSpeed(float spinSpeed) {
        mSpinSpeed = spinSpeed;
        updatePropsIfNeed();
    }

}