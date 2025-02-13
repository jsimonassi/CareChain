import React from 'react';
import {StyledButton, StyledButtonText} from './styles';
import {DefaultTheme} from 'styled-components/native';

export interface MainButtonProps {
  onPress?: () => void;
  label: string;
  backgroundColor?: keyof DefaultTheme['palette'];
  textColor?: keyof DefaultTheme['palette'];
  rightIcon?: React.ReactNode;
}

export const MainButton = ({
  label,
  onPress,
  backgroundColor,
  textColor,
  rightIcon,
}: MainButtonProps) => {
  return (
    <StyledButton onPress={onPress} backgroundColor={backgroundColor}>
      <StyledButtonText textColor={textColor}>{label}</StyledButtonText>
      {rightIcon}
    </StyledButton>
  );
};
