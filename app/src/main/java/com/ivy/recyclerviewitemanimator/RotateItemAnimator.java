package com.ivy.recyclerviewitemanimator;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by ivy on 2017/3/21.
 * Description：
 */

public class RotateItemAnimator extends BaseItemAnimator{
    @Override
    public void setRemoveAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        ViewCompat.setPivotX(holder.itemView,0);
        ViewCompat.setPivotY(holder.itemView,holder.itemView.getHeight()/2);
        animator.rotationY(90);
    }

    @Override
    public void removeAnimationEnd(RecyclerView.ViewHolder holder) {
        ViewCompat.setRotationY(holder.itemView,0);
    }

    @Override
    public void addAnimationInit(RecyclerView.ViewHolder holder) {
        ViewCompat.setPivotX(holder.itemView,holder.itemView.getWidth());
        ViewCompat.setPivotY(holder.itemView,holder.itemView.getHeight()/2);
        ViewCompat.setRotationY(holder.itemView,-90);
    }

    @Override
    public void setAddAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        animator.rotationY(0);
    }

    @Override
    public void addAnimationCancel(RecyclerView.ViewHolder holder) {
        ViewCompat.setRotationY(holder.itemView,0);
    }

    @Override
    public void setOldChangeAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        ViewCompat.setPivotX(holder.itemView,holder.itemView.getWidth()/2);
        ViewCompat.setPivotY(holder.itemView,holder.itemView.getHeight()/2);
        animator.rotationY(90);
    }

    @Override
    public void oldChangeAnimationEnd(RecyclerView.ViewHolder holder) {
        ViewCompat.setRotationY(holder.itemView,0);
    }

    @Override
    public void newChangeAnimationInit(RecyclerView.ViewHolder holder) {
        ViewCompat.setPivotX(holder.itemView,holder.itemView.getWidth()/2);
        ViewCompat.setPivotY(holder.itemView,holder.itemView.getHeight()/2);
        ViewCompat.setRotationY(holder.itemView,-90);
    }

    @Override
    public void setNewChangeAnimation(RecyclerView.ViewHolder holder, ViewPropertyAnimatorCompat animator) {
        animator.rotationY(0).setStartDelay(getChangeDuration());
    }

    @Override
    public void newChangeAnimationEnd(RecyclerView.ViewHolder holder) {
        ViewCompat.setRotationY(holder.itemView,0);
        ViewCompat.animate(holder.itemView).setStartDelay(0);
    }
}
