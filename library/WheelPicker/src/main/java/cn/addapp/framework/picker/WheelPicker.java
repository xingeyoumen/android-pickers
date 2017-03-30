package cn.addapp.framework.picker;

import android.app.Activity;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.View;

import cn.addapp.framework.popup.ConfirmDialog;
import cn.addapp.framework.widget.WheelView;

/**
 * 滑轮选择器
 *
 * @author matt : addapp.cn
 * @since 2015/12/22
 */
public abstract class WheelPicker extends ConfirmDialog<View> {
    protected int textSize = WheelView.TEXT_SIZE;
    protected int textColorNormal = WheelView.TEXT_COLOR_NORMAL;
    protected int textColorFocus = WheelView.TEXT_COLOR_FOCUS;
    protected int offset = WheelView.ITEM_OFF_SET;
    protected boolean canLoop = true;
    protected boolean iosModeEnable = false;
    protected WheelView.LineConfig lineConfig;
    private View contentView;

    public WheelPicker(Activity activity) {
        super(activity);
    }

    /**
     * 设置文字大小
     */
    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    /**
     * 设置未选中文字颜色
     */
    public void setUnSelectedTextColor(@ColorInt int unSelectedTextColor) {
        this.textColorNormal = unSelectedTextColor;
    }
    /**
     * 设置选中文字颜色
     */
    public void setSelectedTextColor(@ColorInt int selectedTextColor) {
        this.textColorFocus = selectedTextColor;
    }

    /**
     * 设置分隔线是否可见
     */
    public void setLineVisible(boolean lineVisible) {
        if (null == lineConfig) {
            lineConfig = new WheelView.LineConfig();
        }
        lineConfig.setVisible(lineVisible);
    }

    /**
     * 设置分隔阴影是否可见
     */
    public void setShadowVisible(boolean shadowVisible) {
        if (null == lineConfig) {
            lineConfig = new WheelView.LineConfig();
        }
        lineConfig.setShadowVisible(shadowVisible);
    }

    /**
     * 设置分隔线颜色
     */
    public void setLineColor(@ColorInt int lineColor) {
        if (null == lineConfig) {
            lineConfig = new WheelView.LineConfig();
        }
        lineConfig.setVisible(true);
        lineConfig.setColor(lineColor);
    }

    /**
     * 设置分隔线配置项，设置null将隐藏分割线及阴影
     */
    public void setLineConfig(@Nullable WheelView.LineConfig config) {
        if (null == config) {
            lineConfig = new WheelView.LineConfig();
            lineConfig.setVisible(false);
            lineConfig.setShadowVisible(false);
        } else {
            lineConfig = config;
        }
    }

    /**
     * 设置选项偏移量，可用来要设置显示的条目数，范围为1-3。
     * 1显示3条、2显示5条、3显示7条
     */
    public void setOffset(@IntRange(from = 1, to = 3) int offset) {
        this.offset = offset;
    }

    /**
     * 设置是否禁用循环
     */
    public void setCanLoop(boolean canLoop) {
        this.canLoop = canLoop;
    }
    /**
     * 设置是否启用ios滚轮模式
     */
    public void setIosModeEnable(boolean iosModeEnable) {
        this.iosModeEnable = iosModeEnable;
    }
    /**
     * 得到选择器视图，可内嵌到其他视图容器
     */
    @Override
    public View getContentView() {
        if (null == contentView) {
            contentView = makeCenterView();
        }
        return contentView;
    }

}
