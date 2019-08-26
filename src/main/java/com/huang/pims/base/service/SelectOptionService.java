package com.huang.pims.base.service;

import com.huang.pims.base.vo.SelectOption;

public interface SelectOptionService<T> {

    SelectOption format(T t);

}
