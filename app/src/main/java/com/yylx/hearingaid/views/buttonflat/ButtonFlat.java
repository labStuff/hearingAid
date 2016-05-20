package com.yylx.hearingaid.views.buttonflat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yylx.hearingaid.R;


public class ButtonFlat extends Button {

	TextView textButton;

	public ButtonFlat(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	protected void setDefaultProperties() {
		minHeight = 16;
		minWidth = 16;
		rippleSize = 4;
		// Min size
		setMinimumHeight(Utils.dpToPx(minHeight, getResources()));
		setMinimumWidth(Utils.dpToPx(minWidth, getResources()));
		setBackgroundResource(R.drawable.background_transparent);
	}

	@Override
	protected void setAttributes(AttributeSet attrs) {
		// Set text button
		String text = null;
		int textResource = attrs.getAttributeResourceValue(ANDROIDXML, "text",
				-1);
		if (textResource != -1) {
			text = getResources().getString(textResource);
		} else {
			text = attrs.getAttributeValue(ANDROIDXML, "text");
		}
		if (text != null) {
			textButton = new TextView(getContext());
			textButton.setText(text);
			textButton.setTextColor(backgroundColor);
			// textButton.setTypeface(null, Typeface.BOLD);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
			textButton.setLayoutParams(params);

			addView(textButton);
		}
		int bacgroundColor = attrs.getAttributeResourceValue(ANDROIDXML,
				"background", -1);
		if (bacgroundColor != -1) {
			setBackgroundColor(getResources().getColor(bacgroundColor));
		} else {
			// Color by hexadecimal
			// Color by hexadecimal
			background = attrs.getAttributeIntValue(ANDROIDXML, "background",
					-1);
			if (background != -1)
				setBackgroundColor(background);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (x != -1) {

			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(rippleColor);
			canvas.drawCircle(x, y, radius, paint);
			if (radius > getHeight() / rippleSize)
				radius += rippleSpeed;
			if (radius >= getWidth()) {
				x = -1;
				y = -1;
				radius = getHeight() / rippleSize;
				if (onClickListener != null && clickAfterRipple)
					onClickListener.onClick(this);
			}
			invalidate();
		}

	}

	/**
	 * Make a dark color to ripple effect
	 * 
	 * @return
	 */
	@Override
	protected int makePressColor() {
		return Color.parseColor("#9e9e9e");
	}

	public void setText(int resid) {
		textButton.setText(resid);
	}

	public void setText(CharSequence text) {
		textButton.setText(text);
	}

	// Set color of background
	public void setBackgroundColor(int color) {
		backgroundColor = color;
		if (isEnabled())
			beforeBackground = backgroundColor;
		textButton.setTextColor(color);
	}

	@Override
	public TextView getTextView() {
		return textButton;
	}

	public String getText() {
		return textButton.getText().toString();
	}

	public void setTextColor(int color) {
		textButton.setTextColor(color);
	}

	public void setTextSize(int dpSize) {
		textButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dpSize);
	}
}
