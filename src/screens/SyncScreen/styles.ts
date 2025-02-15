import styled from 'styled-components/native';

export const Container = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  align-items: center;
`;

export const ContainerSync = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  align-items: center;
  width: 90%;
  margin-top: 5%;
`;

export const ContainerTop = styled.View`
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  gap: 10px;
`;

export const DeviceContainer = styled.View`
  background-color: ${({theme}) => theme.palette.primaryColor};
  display: flex;
  flex-direction: row;
  width: 294px;
  height: 71px;
  border-radius: 15px;
`;

export const SubDeviceContainer = styled.View`
  background-color: ${({theme}) => theme.palette.primaryColor};
  display: flex;
  flex-direction: column;
  justify-content: center;
`;

export const SmartwatchImgContainer = styled.View`
  background-color: ${({theme}) => theme.palette.primaryColor};
  align-items: center;
  justify-content: center;
  width: 50;
  border-radius: 20px;
`;

export const SyncButton = styled.TouchableOpacity`
  background-color: ${({theme}) => theme.palette.primaryColor};
  display: flex;
  flex-direction: column;
  width: 57px;
  height: 71px;
  border-radius: 15px;
  justify-content: center;
  align-items: center;
  align-self: flex-start;
`;

export const MoneyImg = styled.Image`
  object-fit: contain;
  height: 24px;
  width: 24px;
`;

export const SmartwatchImg = styled.Image`
  object-fit: contain;
  height: 31px;
  width: 31px;
`;

export const TextDevice = styled.Text`
  font-size: 20;
  font-weight: bold;
  color: ${({theme}) => theme.palette.white};
`;

export const DeviceTextDescription = styled.Text`
  color: ${({theme}) => theme.palette.secondaryColor};
  font-size: 13;
`;
