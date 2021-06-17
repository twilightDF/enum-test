package cn.twilight.test.PSmode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FishType {
    鲫鱼(0),
    鲤鱼(1),
    黑鱼(2),
    青鱼(3),
    草鱼(4),
    鲈鱼(5);

    public int code;
    public static FishType getType(int code){
        for (FishType f:FishType.values()){
            if (f.code == code)
                return f;
        }
        return null;
    }
}
