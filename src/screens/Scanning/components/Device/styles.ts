import styled from 'styled-components/native';

export const DeviceButton = styled.TouchableOpacity`
  background-color: ${({theme}) => theme.palette.primaryColor};
  display: flex;
  flex-direction: column;
  width: 351px;
  height: 80;
  border-radius: 15px;
  justify-content: center;
  align-self: fle;
`;

export const DeviceContainerInside = styled.View`
  flex: 1;
  margin-left: 5%;
  justify-content: center;
`;

export const DeviceTextTitle = styled.Text`
  color: ${({theme}) => theme.palette.white};
  font-size: 20;
`;

export const DeviceTextDescription = styled.Text`
  color: ${({theme}) => theme.palette.secondaryColor};
  font-size: 13;
`;
