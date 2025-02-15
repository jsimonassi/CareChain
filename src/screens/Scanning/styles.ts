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
  gap: 20px;
`;

export const SubTitleText = styled.Text`
  color: ${({theme}) => theme.palette.black};
  font-size: 14px;
  align-self: flex-start;
`;
