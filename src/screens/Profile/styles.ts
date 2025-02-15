import styled from 'styled-components/native';

export const Container = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const ProfileContainer = styled.View`
  flex: 1;
  display: flex;
  align-items: center;
`;

export const ProfileImg = styled.Image`
  object-fit: contain;
  height: 162px;
  width: 162px;
`;

export const TitleText = styled.Text`
  color: ${({theme}) => theme.palette.primaryColor};
  font-size: 24px;
  font-weight: bold;
  margin-top: 5%;
  margin-bottom: 10%;
`;

export const SubTitleText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 14px;
`;
export const InputsContainer = styled.View`
  margin-top: 10%;
  gap: 10px;
`;
