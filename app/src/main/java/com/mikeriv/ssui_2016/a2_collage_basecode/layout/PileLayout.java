package com.mikeriv.ssui_2016.a2_collage_basecode.layout;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.VisualElement;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.LayoutDrawing;

public class PileLayout extends LayoutDrawing {
    /***
     *
     * @param x x轴坐标
     * @param y y轴坐标
     * @param w 宽
     * @param h 高
     */
    public PileLayout(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    @Override
    public void doLayout() {
        float xp = getX();
        float yp = getY();
        for (VisualElement child :
                children) {
            child.setPosition(xp, yp);
            child.doLayout();
        }
    }
}
