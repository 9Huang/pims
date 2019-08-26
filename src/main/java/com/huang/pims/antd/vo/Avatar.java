package com.huang.pims.antd.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Setter
@Getter
@RequiredArgsConstructor
public class Avatar {

    private ShapeEnum shape;

    private String size;

    private String src;

    private String srcSet;

    private String icon;

    private Object style;

    private String prefixCls;

    private String className;

    private List<ReactNode> children;

    private String alt;

    public enum ShapeEnum {

        CIRCLE("circle","圆形"), SQUARE("square", "正方形");

        private String code;

        private String desc;

        ShapeEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        private static Map<String, ShapeEnum> enumMap = new HashMap<>(3);

        static {
            for (ShapeEnum shapeEnum : ShapeEnum.values()) {
                enumMap.put(shapeEnum.getCode(), shapeEnum);
            }
        }

        public static ShapeEnum getByCode(String code) {
            return Objects.isNull(code) ? null : enumMap.get(code);
        }

    }

}

//export interface AvatarProps {
//    shape?: 'circle' | 'square';
//    size?: 'large' | 'small' | 'default' | number;
//    /** Src of image avatar */
//    src?: string;
//    /** Srcset of image avatar */
//    srcSet?: string;
//    /** Type of the Icon to be used in avatar */
//    icon?: string;
//    style?: React.CSSProperties;
//    prefixCls?: string;
//    className?: string;
//    children?: React.ReactNode;
//    alt?: string;
//    onError?: () => boolean;
//}