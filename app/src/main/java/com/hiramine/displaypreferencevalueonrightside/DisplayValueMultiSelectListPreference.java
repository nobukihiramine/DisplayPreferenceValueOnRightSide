package com.hiramine.displaypreferencevalueonrightside;

import android.content.Context;
import android.preference.MultiSelectListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Set;

public class DisplayValueMultiSelectListPreference extends MultiSelectListPreference
{
	public DisplayValueMultiSelectListPreference( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );
	}

	public DisplayValueMultiSelectListPreference( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );
	}

	public DisplayValueMultiSelectListPreference( Context context, AttributeSet attrs )
	{
		super( context, attrs );
	}

	public DisplayValueMultiSelectListPreference( Context context )
	{
		super( context );
	}

	@Override
	protected View onCreateView( ViewGroup parent )
	{
		setWidgetLayoutResource( R.layout.widget_preferencevalue );
		return super.onCreateView( parent );
	}

	@Override
	protected void onBindView( View view )
	{
		super.onBindView( view );
		TextView textView = (TextView)view.findViewById( R.id.textview_preferencevalue );

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

	// 複数項目選択ダイアログの結果を、TextViewに反映されるために、notifyChanged() が必要。
	// （DisplayValueEditTextPreference、DisplayValueListPreferenceは、
	// 　親クラスのsetValues()にnotifyChanged()呼び出しがあるので、不要）
	@Override
	public void setValues(Set<String> values)
	{
		super.setValues( values );

		notifyChanged();
	}
}
