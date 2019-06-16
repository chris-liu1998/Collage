package com.mikeriv.ssui_2016.a2_collage_basecode.layout;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.VisualElement;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.LayoutDrawing;

public class ColumnLayout extends LayoutDrawing {
    /***
     *
     * @param x x轴坐标
     * @param y y轴坐标
     * @param w 宽
     * @param h 高
     */
    public ColumnLayout(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    @Override
    public void doLayout() {
        float xp = getX() + getW() / 2;
        float yp = getY();
        for (VisualElement child :
                children) {
            child.setPosition(xp - child.getW() / 2, yp); //水平居中
            yp += child.getH();
            child.doLayout();
        }
    }
}
