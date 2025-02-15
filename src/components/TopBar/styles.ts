import styled from 'styled-components/native';

export const TopBar = styled.View`
  background-color: ${({theme}) => theme.palette.primaryColor};
  border-bottom-right-radius: 20px;
  border-bottom-left-radius: 20px;
  height: 10%;
  display: flex;
  flex-direction: row;
`;

export const TopBarLeftSide = styled.View`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 20%;
`;

export const TopBarRightSide = styled.View`
  display: flex;
  flex: 1;
  justify-content: center;
`;

export const ConnectedText = styled.Text`
  color: ${({theme}) => theme.palette.secondaryColorLight};
  size: 13px;
`;

export const WalletText = styled.Text`
  color: ${({theme}) => theme.palette.secondaryColorLight};
  font-size: 20px;
  font-weight: bold;
`;

export const StyledMetamaskLogo = styled.Image`
  object-fit: contain;
  height: 30px;
  width: 30px;
`;
