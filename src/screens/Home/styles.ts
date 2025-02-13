import styled from 'styled-components/native';

export const Container = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  justify-content: center;
  align-items: center;
`;

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

export const HomeContainer = styled.View`
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const RunningLogo = styled.Image`
  object-fit: contain;
`;

export const TitleText = styled.Text`
  color: ${({theme}) => theme.palette.primaryColor};
  font-size: 24px;
  font-weight: bold;
`;

export const SubTitleText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 14px;
`;
