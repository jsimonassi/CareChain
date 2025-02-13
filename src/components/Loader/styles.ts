import styled from 'styled-components/native';

export const StyledContainer = styled.View`
  flex: 1;
  background-color: ${({theme}) => theme.palette.primaryColor};
  justify-content: center;
  align-items: center;
`;
