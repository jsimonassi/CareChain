import styled from 'styled-components/native';

export const StyledButton = styled.TouchableOpacity<MainButtonProps>`
  background-color: ${({backgroundColor, theme}) =>
    backgroundColor
      ? theme.palette[backgroundColor as keyof typeof theme.palette]
      : theme.palette.secondaryColorLight};
  border-radius: 16px;
  width: 80%;
  height: 50px;
  justify-content: center;
  align-items: center;
  flex-direction: row;
  margin-bottom: 10%;
`;

export const StyledButtonText = styled.Text<MainButtonProps>`
  ${({theme}) => theme.typography.text2};
  color: ${({textColor, theme}) => textColor || theme.typography.text2.color};
`;

interface MainButtonProps {
  backgroundColor?: string;
  textColor?: string;
}
