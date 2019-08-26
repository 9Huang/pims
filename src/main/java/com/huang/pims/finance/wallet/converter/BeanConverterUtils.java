package com.huang.pims.finance.wallet.converter;

import com.huang.pims.finance.wallet.model.WalletClass;
import com.huang.pims.finance.wallet.vo.WalletClassVO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanConverterUtils {

    public static WalletClassVO toVO(WalletClass walletClass) {
        return new WalletClassVO(walletClass.getId(), walletClass.getClassIcon(), walletClass.getClassName(), walletClass.getClassDesc());
    }

    public static List<WalletClassVO> toVOList(List<WalletClass> walletClassList) {
        return walletClassList.stream().map(BeanConverterUtils::toVO).collect(Collectors.toList());
    }


}
