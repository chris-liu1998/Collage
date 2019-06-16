package com.mikeriv.ssui_2016.a2_collage_basecode.baseElement;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

public class BaseVisualElement extends PrebaseVisualElement {
    protected float x;
    protected float y;
    protected float w;
    protected float h;
    protected VisualElement parent = null;
    protected List<VisualElement> children;

    public BaseVisualElement(float xLoc, float yLoc) {
        super(xLoc, yLoc);
        children = new ArrayList<>();
    }

    public BaseVisualElement(float xLoc, float yLoc, float width, float height) {
        super(xLoc, yLoc, width, height);
        children = new ArrayList<>();
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setH(float h) {
        if (sizeIsIntrinsic()) {
            return;
        }
        this.h = h;
    }

    @Override
    public void setW(float w) {
        if (sizeIsIntrinsic()) {
            return;
        }
        this.w = w;
    }

    @Override
    public void setParent(VisualElement newParent) {
        this.parent = newParent;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getH() {
        return h;
    }

    @Override
    public float getW() {
        return w;
    }

    @Override
    public VisualElement getParent() {
        return parent;
    }

    @Override
    public int getNumChildren() {
        return children.size();
    }

    @Override
    public VisualElement getChildAt(int index) {
        if (index < 0) {
            return null;
        } else if (index < getNumChildren()) {
            return children.get(index);
        } else {
            return null;
        }
    }

    @Override
    public int findChild(VisualElement child) {
        if (child == null) {
            return -1;
        }
        return children.indexOf(child);
    }

    @Override
    public void addChild(VisualElement child) {
        if (child == null) {
            return;
        }
        VisualElement parent = child.getParent();
        if (parent != null) {
            children.remove(child);
        }
        child.setParent(this);
        children.add(child);
    }

    @Override
    public void removeChild(VisualElement child) {
        children.remove(child);
    }

    @Override
    public void removeChildAt(int index) {
        if (index < getNumChildren()) {
            children.remove(index);
        } else {
            return;
        }
    }

    @Override
    public void moveChildFirst(VisualElement child) {
        children.remove(child);
        children.add(0, child);
    }

    @Override
    public void moveChildEarlier(VisualElement child) {
        int index = children.indexOf(child);
        if (index < 1) {
            return;
        }
        children.remove(child);
        children.add(index - 1, child);
    }

    @Override
    public void moveChildLast(VisualElement child) {
        children.remove(child);
        children.add(child);
    }

    @Override
    public void moveChildLater(VisualElement child) {
        int index = children.indexOf(child);
        if (index >= children.size() - 1 || index < 0) {
            return;
        }
        children.remove(child);
        children.add(index + 1, child);
    }

    @Override
    public void doLayout() {
        for (VisualElement child : children) {
            child.setPosition(this.getX() + child.getX(), this.getY() + child.getY());
            child.doLayout();
        }
    }

    @Override
    public void draw(Canvas onCanvas) {
        for (VisualElement child : children) {
            child.draw(onCanvas);
        }
    }
}
