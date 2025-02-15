import StyleSheet from 'styled-components/dist/sheet';
import styled from 'styled-components/native';

export const Container = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.white};
  display: flex;
  align-items: center;
`;

export const Title = styled.Text`
  margin-top: 10%;
  font-size: 24px;
  color: ${({theme}) => theme.palette.primaryColor};
  font-weight: bold;
  margin-bottom: 10%;
`;

export const LocationImage = styled.Image`
  object-fit: contain;
  height: 248px;
  width: 248px;
`;

export const SubTitleText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 14px;
  text-align: center;
`;
export const LocationContainer = styled.View`
  flex: 1;
  display: flex;
  align-items: center;
`;

export const TextView = styled.View`
  width: 80%;
  margin-top: 10%;
`;
