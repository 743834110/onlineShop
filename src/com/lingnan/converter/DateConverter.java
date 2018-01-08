package com.lingnan.converter;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter {
    //֧��ת���Ķ������ڸ�ʽ��������ʱ���ʽ
    private final DateFormat[] dfs={
        new SimpleDateFormat("yyyy��MM��dd��  "),
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
        new SimpleDateFormat("MM/dd/yy"),
        new SimpleDateFormat("yyyy.MM.dd"),
        new SimpleDateFormat("yy.MM.dd"),
        new SimpleDateFormat("yyyy/MM/dd")
    };

    //����
	@Override
	public Object convertFromString(Map context, String[] values, Class toType) {
		String dateStr=values[0];       //��ȡ���ڵ��ַ���
        for (int i = 0; i < dfs.length; i++) {   //��������֧�ָ�ʽ������ת��
            try {
            	System.out.println(dfs[i].toString());
                return dfs[i].parse(dateStr);
            } catch (Exception e) {
                continue;
            }
        }
        //���������Ϻ���û��ת���ɹ�����ʾ����ת���쳣
        throw new TypeConversionException();
	}
	
	//���(ognl���ʱ�ĸ�ʽ )
	@Override
	public String convertToString(Map context, Object object) {
        Date date=(Date) object;
        //�����ʽ��yyyy-MM-dd
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

}
