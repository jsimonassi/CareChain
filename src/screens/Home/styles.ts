import styled from 'styled-components/native';

export const Container = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  justify-content: center;
  align-items: center;
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
