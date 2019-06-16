package com.mikeriv.ssui_2016.a2_collage_basecode.layout;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.VisualElement;
import com.mikeriv.ssui_2016.a2_collage_basecode.drawing.LayoutDrawing;

public class CircleLayout extends LayoutDrawing {
    private float centerX;
    private float centerY;
    private float radius;

    /***
     *
     * @param x x轴坐标
     * @param y y轴坐标
     * @param w 宽
     * @param h 高
     * @param layoutCenterX  圆心
     * @param layoutCenterY
     * @param layoutRadius  半径
     */
    public CircleLayout(float x, float y, float w, float h, float layoutCenterX, float layoutCenterY, float layoutRadius) {
        super(x, y, w, h);
        if (layoutCenterX < 0 || layoutCenterX > w) {
            centerX = w / 2;
        } else {
            centerX = layoutCenterX;
        }
        if (layoutCenterY < 0 || layoutCenterY > h) {
            centerY = h / 2;
        } else {
            centerY = layoutCenterY;
        }
        float rX, rY;
        rX = (centerX > w / 2) ? (w - centerX) : (centerX);
        rY = (centerY > h / 2) ? (h - centerY) : (centerY);
        if (layoutRadius > rX || layoutRadius > rY) {
            radius = (rX > rY) ? (rY) : (rX);
        } else {
            radius = layoutRadius;
        }
    }

    @Override
    public void doLayout() {

        int count = getNumChildren(), i = 0;
        final float PI = (float) Math.PI * 2;
        float sin, cos;
        float X, Y;
        for (VisualElement child :
                children) {
            sin = (float) Math.sin(0 + PI * i / count);
            cos = (float) Math.cos(0 + PI * i / count);
            X = getX() + centerX + radius * cos - child.getX() / 2;
            Y = getY() + centerY + radius * sin - child.getY() / 2;
            System.err.println("X:" + X + "; Y:" + Y);
            child.setPosition(X, Y);
            i++;
            child.doLayout();
        }
    }
}
