package com.hiramine.displaypreferencevalueonrightside;

import android.content.Context;
import android.preference.MultiSelectListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Set;

public class MultiSelectListPreferenceDisplayValue extends MultiSelectListPreference
{
	public MultiSelectListPreferenceDisplayValue( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );
	}

	public MultiSelectListPreferenceDisplayValue( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );
	}

	public MultiSelectListPreferenceDisplayValue( Context context, AttributeSet attrs )
	{
		super( context, attrs );
	}

	public MultiSelectListPreferenceDisplayValue( Context context )
	{
		super( context );
	}

	@Override
	protected View onCreateView( ViewGroup parent )
	{
		setWidgetLayoutResource( R.layout.widget_valuetext );
		return super.onCreateView( parent );
	}

	@Override
	protected void onBindView( View view )
	{
		super.onBindView( view );
		TextView textView = (TextView)view.findViewById( R.id.textview_value );

		Set<String>    setstrValue = getValues();
		CharSequence[] aEntry      = getEntries();
		String         strText     = "";
		for( String strValue : setstrValue )
		{
			int index = findIndexOfValue( strValue );
			if( !strText.isEmpty() )
			{
				strText += ", ";
			}
			strText += aEntry[index].toString();
		}
		textView.setText( strText );
	}

	// プリファレンス変更結果を、呼び出し元の画面に反映されるために、notifyChanged() が必要。
	// （EditTextPreferenceDisplayValue、DisplayValueListPreferenceは、
	// 　親クラスのsetValues()にnotifyChanged()呼び出しがあるので、不要）
	@Override
	public void setValues( Set<String> values )
	{
		super.setValues( values );

		notifyChanged();
	}
}
