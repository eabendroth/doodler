package com.example.edwardabendroth.doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import static java.lang.Thread.sleep;


/**
 * Created by Edward Abendroth on 3/9/2016.
 */
public class DoodleView extends View {

//    private Paint _paintDoodle = new Paint();
//    private Path _path = new Path();

//    private Paint _pD2 = new Paint();
//    private Path _p2 = new Path();

//    boolean isP1 = true;

    private ArrayList<Pair<Paint, Path>> _pairs = new ArrayList<Pair<Paint, Path>>();
    private Pair<Paint, Path> _currentPair;
    private boolean firstDraw = true;


    public DoodleView(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(attrs, defStyle);

    }

    private void init(AttributeSet attrs, int defStyle) {
        _currentPair = new Pair<Paint, Path> (new Paint(), new Path());
        _currentPair.first.setColor(Color.RED);
        _currentPair.first.setAntiAlias(true);
        _currentPair.first.setStyle(Paint.Style.STROKE);
        _currentPair.first.setStrokeWidth(0);
        _pairs.add(_currentPair);
    }

    @Override
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPath(_p2, _pD2);
//        canvas.drawPath(_path, _paintDoodle);
//        Pair<Paint, Path> _newCurrentPair = new Pair<Paint, Path>(new Paint(), new Path());
//        _newCurrentPair.first.setAntiAlias(true);
//        _newCurrentPair.first.setStyle(Paint.Style.STROKE);
//        _newCurrentPair.first.setStrokeWidth(_currentPair.first.getStrokeWidth());
//        _newCurrentPair.first.setColor(_currentPair.first.getColor());
//        _pairs.add(_newCurrentPair);
//        _currentPair = _newCurrentPair;
        for (Pair<Paint, Path> p : _pairs) {
            canvas.drawPath(p.second, p.first);
        }
//        if (firstDraw) {
//            firstDraw = false;
//            new Thread(new Runnable() {
//                public void run() {
//                    while (true) {
//                        for (Pair<Paint, Path> p : _pairs) {
//                            canvas.drawPath(p.second, p.first);
//                        }
//                        try {
//                            sleep(1000);
//                        } catch (InterruptedException e) {
//                            break;
//                        }
//                    }
//
//                }
//            }
//
//            ).start();
//            while (true) {
//                for (Pair<Paint, Path> p : _pairs) {
//                    canvas.drawPath(p.second, p.first);
//                }
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    break;
//                }
//            }
//        }
    }

    @Override
    public boolean onTouchEvent (MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _currentPair.second.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                _currentPair.second.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }


    public void clear() {
        //_paintDoodle = new Paint();
        //_path.reset();
        //_p2.reset();
        for (Pair<Paint, Path> p : _pairs) {
            p.second.reset();
        }
        _pairs.clear();
        _pairs.add(_currentPair);
        //_paintDoodle.setAntiAlias(true);
        //_paintDoodle.setStyle(Paint.Style.STROKE);
        //_paintDoodle.setColor(Color.WHITE);
        invalidate();
        //float previousWidth = _paintDoodle.getStrokeWidth();
        //int previousColor = _paintDoodle.getColor();
        //_paintDoodle.setStrokeWidth(getHeight());
        //_paintDoodle.setColor(Color.WHITE);
        //_path.moveTo(0, 0);
        //_path.lineTo(1, 1);
        //_paintDoodle.setStrokeWidth(previousWidth);
        //_paintDoodle.setColor(previousColor);
    }

    public void blue() {
//        if (isP1) {
//            isP1 = false;
//        } else {
//            isP1 = true;
//        }
//        _pD2.setColor(Color.BLUE);
//        _pD2.setAntiAlias(true);
//        _pD2.setStyle(Paint.Style.STROKE);
//        invalidate();

    }

    public void changeColor(int id) {

        Pair<Paint, Path> _newCurrentPair = new Pair<Paint, Path>(new Paint(), new Path());
        _newCurrentPair.first.setAntiAlias(true);
        _newCurrentPair.first.setStyle(Paint.Style.STROKE);
        _newCurrentPair.first.setStrokeWidth(_currentPair.first.getStrokeWidth());

        //It's going to need to inherit non-color attributes too.
        switch(id) {
            case R.id.red:
                _newCurrentPair.first.setColor(Color.rgb(255,0,0));
                break;
            case R.id.orange:
                _newCurrentPair.first.setColor(Color.rgb(255,102,0));
                break;
            case R.id.yellow:
                _newCurrentPair.first.setColor(Color.rgb(255,204,0));
                break;
            case R.id.green:
                _newCurrentPair.first.setColor(Color.rgb(0,153,0));
                break;
            case R.id.blue:
                _newCurrentPair.first.setColor(Color.rgb(0,0,255));
                break;
            case R.id.purple:
                _newCurrentPair.first.setColor(Color.rgb(153,51,204));
                break;
            case R.id.black:
                _newCurrentPair.first.setColor(Color.rgb(0,0,0));
                //_newCurrentPair.first.setAlpha(254);
                break;
        }
        _newCurrentPair.first.setAlpha(_currentPair.first.getAlpha());
        _pairs.add(_newCurrentPair);
        _currentPair = _newCurrentPair;

    }

    public void changeSize(int newSize) {

        Pair<Paint, Path> _newCurrentPair = new Pair<Paint, Path>(new Paint(), new Path());
        _newCurrentPair.first.setAntiAlias(true);
        _newCurrentPair.first.setStyle(Paint.Style.STROKE);
        _newCurrentPair.first.setStrokeWidth(newSize);
        _newCurrentPair.first.setAlpha(_currentPair.first.getAlpha());
        _newCurrentPair.first.setColor(_currentPair.first.getColor());
        _pairs.add(_newCurrentPair);
        _currentPair = _newCurrentPair;

    }

    public void changeOpacity(int newOpacity) {
        Pair<Paint, Path> _newCurrentPair = new Pair<Paint, Path>(new Paint(), new Path());
        _newCurrentPair.first.setAntiAlias(true);
        _newCurrentPair.first.setStyle(Paint.Style.STROKE);
        _newCurrentPair.first.setStrokeWidth(_currentPair.first.getStrokeWidth());
        _newCurrentPair.first.setColor(_currentPair.first.getColor());
        _newCurrentPair.first.setAlpha(newOpacity);
        _pairs.add(_newCurrentPair);
        _currentPair = _newCurrentPair;
    }

    public void makeDisease() {
        new Thread(new Runnable(){
            public void run() {
                int x = (int) (Math.random()*getWidth()), y = (int) (Math.random()*getHeight());
                while (true) {
                    Paint _dPaint = new Paint();
                    Path _dPath = new Path();
                    _dPaint.setColor(Color.WHITE);
                    _dPaint.setAntiAlias(true);
                    _dPaint.setStyle(Paint.Style.STROKE);
                    _dPaint.setStrokeWidth(20);
                    _dPath.moveTo(x, y);
                    x = x + (int) (Math.random()*50-25);
                    y = y + (int) (Math.random()*50-25);
                    if (x <=0 || y <=0 || x >=getWidth() || y >= getHeight()) {
                        break;
                    }
                    _dPath.lineTo(x, y);
                    _pairs.add(new Pair<Paint, Path>(_dPaint,_dPath));
//                    Pair<Paint, Path> _newCurrentPair = new Pair<Paint, Path>(new Paint(), new Path());
//                    _newCurrentPair.first.setAntiAlias(true);
//                    _newCurrentPair.first.setStyle(Paint.Style.STROKE);
//                    _newCurrentPair.first.setStrokeWidth(_currentPair.first.getStrokeWidth());
//                    _newCurrentPair.first.setColor(_currentPair.first.getColor());
//                    _pairs.add(_newCurrentPair);
//                    _currentPair = _newCurrentPair;




                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        return;
                    }


                }
            }
        }).start();
    }


}
