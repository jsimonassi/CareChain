import styled from 'styled-components/native';

export const Container = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  align-items: center;
`;
export const SubContainer = styled.View`
  flex: 1;
  /* background-color: ${({theme}) => theme.palette.white}; */
  display: flex;
  align-items: center;
  width: 90%;
`;

export const ContainerDeviceNotFound = styled.View`
  flex: 1;
  /* background-color: ${({theme}) => theme.palette.white}; */
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const SubTitleText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 14px;
  align-self: flex-start;
  margin-bottom: 20px;
  margin-top: 10px;
`;

export const SubTitleTextDeviceNotFound = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 14px;
`;

export const DeviceImg = styled.Image`
  object-fit: contain;
  height: 174px;
  width: 277px;
`;

export const TitleText = styled.Text`
  color: ${({theme}) => theme.palette.primaryColor};
  font-size: 24px;
  font-weight: bold;
  margin-top: 5%;
  margin-bottom: 10%;
`;
