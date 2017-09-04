package com.example.lixin.lixin20170904.view;
/**
 *
 *自定义view界面
 *
 */

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.lixin.lixin20170904.R;

/**
 * Created by hua on 2017/9/4.
 */

public class MyCustomView extends View {

    private float mradius;
    private float mstrokewidth;
    private int mcolor;
    private float mRingRadius;
    private Paint paint;
    private int changescolor;

    public MyCustomView(Context context) {
        super(context);
        initAttrs(context,null);
    }


    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
    }


    private void initAttrs(Context context, @Nullable AttributeSet attrs) {

        if (attrs == null){
            return;
        }
        //得到自定义属性
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);

        mradius = typedArray.getDimension(R.styleable.MyCustomView_radius, 300);
        mstrokewidth = typedArray.getDimension(R.styleable.MyCustomView_strokewidth, 20);
        mcolor = typedArray.getColor(R.styleable.MyCustomView_color, Color.BLACK);
        typedArray.recycle();
        mRingRadius = mradius + mstrokewidth / 2;
    }
    //改变颜色的方法
    public void setColor(int color){
        this.changescolor = color;
        System.out.println("------------"+changescolor);
        invalidate();
    }
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        int center = getWidth()/2;
        int radius = (int) (center-mradius/2);
        if (changescolor == 1){
            paint.setColor(Color.BLUE);
        }else {
            paint.setColor(mcolor);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mstrokewidth);
        paint.setAntiAlias(true);
        canvas.drawCircle(center,center,radius,paint);


        paint.setStrokeWidth(20);
        paint.setColor(0xff0000);
        RectF rectF = new RectF(center - radius, center - radius, center + radius, center + radius);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF,0,360,false,paint);
        ObjectAnimator rotationObjectAnimator = new ObjectAnimator().ofFloat(paint,"rotation",0f,-360f,-360f,0f);
        rotationObjectAnimator.setDuration(8000);
        rotationObjectAnimator.start();
    }

    public interface OnClickListener{
        void onClickListener(View view);
    }
    private OnClickListener mOnClickListener;
    public void SetOnclickListener(OnClickListener onClickListener){
        mOnClickListener = onClickListener;
    }

}
